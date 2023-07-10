// pages/recommend/recommend.ts
var weight: number;
var height: number;
var old: number;
var checked1: false;
var checked2: false;
// var checked1_: number;
// var checked2_: number;
var radio: number;
var BMR: number;
var gender: number;
Page({
    onLoad() {
        checked1 = false;
        checked2 = false;
    },
    data: {
        radioItems: [
            { value: 1, name: '增肌' },
            { value: 2, name: '减肥' },
            { value: 3, name: '塑形' },
        ],
    },
    gender(e: any) {
        gender = e.detail.value
        console.log(gender);

    },
    radioChange(e: any) {
        radio = e.detail.value
        console.log(radio);
        for (let i = 0, len = this.data.radioItems.length; i < len; i++) {
            var item = this.data.radioItems[i]
            item.checked = item.value == e.detail.value
        }
        console.log(this.data.radioItems);
    },
    onChangeheight(event: any) {
        height = event.detail
        console.log(height);
    },
    onChangeweight(event: any) {
        weight = event.detail
        console.log(weight);
    },
    onChangeold(event: any) {
        old = event.detail
        console.log(old);
    },

    oneChange(event: any) {
        if (checked1 == true) {
            checked1 = false
        } else {
            checked1 = true
        }
        console.log(checked1)
    },
    twoChange(event: any) {
        if (checked2 == true) {
            checked2 = false
        } else {
            checked2 = true
        }
        console.log(checked2)
    },
    start(event) {
        console.log(height, weight, old, checked1, checked2, radio);
        // 1、根据用户输入的身高，年龄和体重计算BMR。
        // 2、根据用户的目标和活动水平确定每日所需的卡路里。
        // 3、根据用户输入的禁忌食物数据排除不允许的食物。
        // 4、根据用户的目标和活动水平推荐健康食物。
        //（1）首先计算基础代谢率（BMR）：基础代谢率是身体在静止状态下消耗的最小热量。它可以根据用户的身高，年龄和体重来计算。
        // 男性 BMR = 88.36 + (13.4 x 体重/kg) + (4.8 x 身高/cm) - (5.7 x 年龄/岁)
        // 女性 BMR = 447.6 + (9.2 x 体重/kg) + (3.1 x 身高/cm) - (4.3 x 年龄/岁)
        if (gender == 1) {
            BMR = 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * old)
            console.log("性别男，BMR为", BMR);
        } else {
            BMR = 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * old)
            console.log("性别女，BMR为", BMR);
        }
        wx.request({
            url: 'http://localhost:8888/start',
            method: 'POST',
            data: { weight: weight, BMR: BMR, checked1: checked1, checked2: checked2, radio: radio },
            header: { "content-type": "application/x-www-form-urlencoded" },
            success(res) {
                console.log(res.data)
            },
            fail(err) {
                console.error(err)
            }
        })
        console.log("1111111");

        wx.navigateTo({
            url: '/pages/meal/meal',
        })
        console.log("222222");
    }
});
