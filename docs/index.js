// var url = 'http://localhost:8088';
var url = 'http://122.51.73.146:8088';
var login = new Vue({
    el: '#Login-frame',
    data: {
        showLogin: true,
        username: '',
        password: ''
    },
    methods: {
        goExam: function () {
            axios.get(url + '/login',{
                params:{
                    username : this.username,
                    password : this.password
                }
            }).then(res=>{
                console.log(res);
                if(res.data.code === 0){
                    this.showLogin = false;
                    exam.showExam = true;
                    exam.getPaper(res.data.data);
                } else {
                    alert("Error："+res.data.msg);
                }
            });
        },
        goRegister: function () {
            this.showLogin = false;
            register.showRegister = true
        }
    }
});
var register = new Vue({
    el: '#Register-frame',
    data: {
        showRegister: false,
        username: '',
        password: '',
        repwd: '',
        tel: ''
    },
    methods: {
        register: function () {
            // console.log("Register");
            axios.get(url + '/register',{
                params:{
                    username: this.username,
                    password: this.password,
                    tel: this.tel
                }
            }).then(res=>{
                if (this.repwd === this.password){
                    if (res.data.code === 0){
                        alert("注册成功，去登陆！");
                        this.showRegister = false;
                        login.showLogin = true;
                    } else {
                        alert("Error：" + res.data.msg);
                    }
                } else {
                    alert("两次密码不一致")
                }
            });
        },
        goLogin: function () {
            this.showRegister = false;
            login.showLogin = true
        }
    }
});
var exam = new Vue({
    el: '#Exam-frame',
    data: {
        showExam: false,
        examId: '',
        pattern: '',
        monitor: '',
        timeLength: '',
        items: '',
        answer: []
    },
    computed:{
        percentageNum: function () {
            let j = 0;
            for({} in this.answer) {
                j++;
            }
            // parseFloat(num) 去小数后零
            // num.toFixed(x) 保留x位小数
            return parseFloat((100*j/this.items.length).toFixed(1))
        }
    },
    methods: {
        getPaper : function (examId) {
            axios.get(url + '/getPaper',{
                params: {
                    examId: examId
                }
            }).then(res=>{
                console.log(res);
                this.examId = res.data.data.id;
                this.items = res.data.data.testTitleList;
                this.timeLength = res.data.data.timeLength;
                if (res.data.data.monitor === 1) {
                    this.monitor = '是'
                } else if (res.data.data.monitor === 0){
                    this.monitor = '否'
                }
                if (res.data.data.pattern === 1) {
                    this.pattern = '限通信模式'
                } else if (res.data.data.pattern === 2) {
                    this.pattern = '霸屏模式'
                }
            })
        },
        submitExam: function () {
            let isDone = true;
            if (this.percentageNum < 100){
                isDone = confirm("题目完成度没有100%，确认结束本次考试吗");
            }
            if (isDone){
                // 答案加 []
                // for (let i = 0; i < this.answer.length; i++) {
                //     this.answer[i] = '['+this.answer[i]+']'
                // }
                axios.post(url + '/submitExam',{
                    examId: this.examId,
                    username: login.username,
                    answer: this.answer,
                }).then(res=>{
                    console.log(this.answer);
                    console.log(res);
                    if (res.data.code === 0){
                        alert(res.data.msg)
                    }
                    else if (res.data.code === -1){
                        alert(res.data.msg)
                    }
                })
            }
        }
    }
});