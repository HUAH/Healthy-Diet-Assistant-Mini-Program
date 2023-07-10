// pages/BMI/BMI.ts
var user_id: number;
var isLogin:false;
var BMI:number;
Page({

    /**
     * 页面的初始数据
     */
    data: {
        height:0,
        weight:0,
        bmi:'',
        info:''     
    },
    heightInput: function (e: { detail: { value: any } }){
        this.setData({
            height: e.detail.value
          })
    console.log(e.detail.value);  
    },
    weightInput: function (e: { detail: { value: any } }){
        this.setData({
            weight: e.detail.value
          })
    console.log(e.detail.value);  
    },
    
    bmicount: function (e: { detail: { value: any } }) {
        var weightnum=parseFloat(this.data.weight)
        var heightnum=parseFloat(this.data.height)
        var bmi=(weightnum/(heightnum/100)/(heightnum/100)).toFixed(2)
        BMI=parseFloat(bmi);
        var info=""
        if(BMI<18.5){
          info="过轻，加强营养！"
        }else if(BMI>=18.5&&BMI<23.9){
          info="正常，继续保持！"
        }else if(BMI>=23.9&&BMI<27.9){
          info="超重，加强锻炼!"
        }else if(BMI>=27.9){
          info="肥胖，提高警惕！"
        }
        console.log(bmi)
        console.log(info)
        this.setData({
          bmi:bmi,
          info:info
        })
      },
      saveBMI(){
        isLogin = wx.getStorageSync("isLogin");
        if (isLogin !== true) {
            wx.showModal({
                title: '请先登录',
                success (res) {
                  if (res.confirm) {
                    console.log('用户点击确定')
                    wx.reLaunch({
                        url:'/pages/me/me',
                      })
                }
              }
            })
        }else{
            user_id = wx.getStorageSync("user_id");
            console.log("获取到缓存的user_id为",user_id);
            console.log(BMI);
            console.log(typeof(BMI));
            wx.request({
                url: 'http://localhost:8888/addBMIData',
                method: 'POST',
                data: {  userID:user_id , BMI: BMI},
                header: { "content-type": "application/x-www-form-urlencoded" },
                success: res => {
                    wx.showToast({
                        title: '保存成功',
                        icon: 'success',
                        duration: 2000
                    })
                }
            })
        }

      },
})