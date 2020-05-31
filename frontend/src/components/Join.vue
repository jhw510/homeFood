<template>
    <div>
        <link rel="stylesheet" href="https://www.kcar.com/resources/css/re_user.css?ver=6.9">
        <div id="contents">
            <div class="user_content">
                <h3 class="policy_tit"><img src="https://www.kcar.com/resources/images/content/user/userInf_tit.gif" alt="기본정보 입력"></h3>
                <div class="user_info">
                    <h4></h4>
                    <table width="100%" class="t_user01">
                        <colgroup>
                            <col width="18%">
                            <col width="*">
                            <col width="13%">
                            <col width="30%">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th><span class="org">*</span> <label for="i_sMemberName">이름</label></th>
                            <td colspan="3"><input type="text" v-model="name" id="i_sMemberName" maxlength="20" class="user_input02" value=""></td>
                        </tr>
                        <tr>
                            <th><span class="org">*</span> <label for="i_sMemberId">아이디</label></th>
                            <td colspan="3">
                                <input type="text" v-model="userid" @keyup="IdCheck" maxlength="12"  class="user_input02" value="">
                                <input type="text" v-model="userid" @keyup="idCheck" maxlength="12" id="i_sMemberId" class="user_input02" value="">
                                <b class="user_num_check mt5" id="id_result">{{idCheckmsg}}</b>
                                <p class="mt5" >* 4~12이내  영문, 숫자 혼합</p>
                            </td>
                        </tr>
                        <tr>
                            <th><span class="org">*</span> <label for="i_sPassWord">비밀번호입력</label></th>
                            <td colspan="3">
                                <input type="password" v-model="passwd" id="i_sPassWord" maxlength="20" class="user_input02 am" value=""> &nbsp;&nbsp;&nbsp;
                                <span>* 영문 대/소문자, 숫자, 특수문자(`~!@#$%^*+=-_만 허용)를 조합하여 8~20자로 입력해 주세요.</span>
                            </td>
                        </tr>
                        <tr>
                            <th><span class="org">*</span> <label for="i_sPassWord2">비밀번호 확인</label></th>
                            <td colspan="3"><input type="password" v-model="passwd2" id="i_sPassWord2" maxlength="20" class="user_input02" value="">
                                <b class="user_num_check mt5" v-if="1<passwd.length && passwd.length<=8">{{passwdCheck}}</b>
                                <b class="user_num_check mt5" v-if="1<passwd.length && passwd.length<8">{{passwdCheck}}</b>
                                <b class="user_num_check mt5" v-show="passwd!=passwd2">{{passwdCheck2}}</b>
                            </td>

                        </tr>
                        <tr>
                            <th><span class="org">*</span> 이메일 </th>
                            <td colspan="3">
                                <input type="text" v-model="email1" id="i_sEmail1" title="이메일 아이디" class="user_input05 am" value="">
                                @
                                <input type="text" v-model="email2" id="i_sEmail2" title="이메일 도메인" class="user_input05 am" placeholder="직접입력">
                                <div class="select open mr">
                                    <select v-model="email2" id="domain">
                                        <option value="직접입력">직접입력</option>
                                        <option value="daum.net">daum.net</option>
                                        <option value="naver.com">naver.com</option>
                                        <option value="nate.com">nate.com</option>
                                        <option value="dreamwiz.com">dreamwiz.com</option>
                                        <option value="empal.com">empal.com</option>
                                        <option value="freechal.com">freechal.com</option>
                                        <option value="gmail.com">gmail.com</option>
                                        <option value="hanafos.com">hanafos.com</option>
                                        <option value="hanmir.com">hanmir.com</option>
                                        <option value="hitel.net">hitel.net</option>
                                        <option value="hotmail.com">hotmail.com</option>
                                        <option value="korea.com">korea.com</option>
                                        <option value="lycos.co.kr">lycos.co.kr</option>
                                        <option value="netian.com">netian.com</option>
                                        <option value="paran.com">paran.com</option>
                                        <option value="yahoo.co.kr">yahoo.co.kr</option>
                                        <option value="chollian.net">chollian.net</option>
                                        <option value="hanmail.net">hanmail.net</option>
                                        <option value="kebi.com">kebi.com</option>
                                    </select>
                                </div>
                            </td>
                        </tr>
                        </tbody></table>
                    <table width="100%" class="t_user01">
                        <colgroup>
                            <col width="18%">
                            <col width="*">
                            <col width="13%">
                            <col width="30%">
                        </colgroup>
                        <tbody><tr>
                            <th>성별 </th>
                            <td colspan="3" style="">
                                <input type="radio" v-model="gender" id="man" value="man"> &nbsp;<label for="man">남성</label>
                                <span class="pr30"></span>
                                <input type="radio" v-model="gender" id="woman" value="woman"> &nbsp;<label for="woman">여성 </label>
                            </td>
                        </tr>
                        <tr>
                            <th>생년월</th>
                            <td colspan="3">
                                <input type="text" v-model="bYear" maxlength="4" class="user_input02 " value="" placeholder="예시) 1997" onkeyup="userEvent.fnBirth();"> &nbsp;<span>년 </span><span class="pr15"></span>
                                <input type="text" v-model="bMonth"  maxlength="2" class="user_input02 am" value="" placeholder="예시) 12" onkeyup="userEvent.fnBirth();"> &nbsp;<span>월  </span>
                            </td>
                            <td>
                                <input type="text" v-model="bYear" id="year" maxlength="4" class="user_input02 " value="" placeholder="예시) 1997" @keyup="yearCheck"> &nbsp;
                                <span>년 </span>
                                <span class="pr15"></span>
                                <input type="text" v-model="bMonth" id="month" maxlength="2" class="user_input02 am" value="" placeholder="예시) 12" @keyup="monthCheck"> &nbsp;
                                <span>월  </span>
                                <b class="user_num_check mt5">{{bmsg}} {{bmmsg}}</b>
                            </td>

                        </tr>
                        <tr>
                            <th>지역 </th>
                            <td colspan="3">
                                <select style="width:130px" v-model="region" id="i_sUserRegion">
                                    <option value="">지역을 선택하세요  </option>
                                    <option value="010">서울</option>
                                    <option value="020">인천</option>
                                    <option value="030">대전</option>
                                    <option value="040">대구</option>
                                    <option value="050">광주</option>
                                    <option value="060">부산</option>
                                    <option value="070">울산</option>
                                    <option value="080">세종</option>
                                    <option value="090">경기</option>
                                    <option value="100">강원</option>
                                    <option value="110">경남</option>
                                    <option value="120">경북</option>
                                    <option value="130">전남</option>
                                    <option value="140">전북</option>
                                    <option value="150">충남</option>
                                    <option value="160">충북</option>
                                    <option value="170">제주</option>
                                </select>
                                <select>
                                    <option value="">지역을 선택하세요  </option>
                                    <option value="서울">서울</option>
                                    <option value="인천">인천</option>
                                    <option value="대전">대전</option>
                                    <option value="대구">대구</option>
                                    <option value="광주">광주</option>
                                    <option value="부산">부산</option>
                                    <option value="울산">울산</option>
                                    <option value="세종">세종</option>
                                    <option value="경기">경기</option>
                                    <option value="강원">강원</option>
                                    <option value="경남">경남</option>
                                    <option value="경북">경북</option>
                                    <option value="전남">전남</option>
                                    <option value="전북">전북</option>
                                    <option value="충남">충남</option>
                                    <option value="충북">충북</option>
                                    <option value="제주">제주</option>
                                </select>
                            </td>
                        </tr>
                        </tbody></table>
                </div>
                <div class="btn_formbts">
                    <a href="#" @click="join" class="btn_form_r"><b>회원가입</b></a>
                    <a href="#" @click="modal" class="btn_form_g"><b>취소</b></a>
                    <a @click.prevent="join" class="btn_form_r"><b>회원가입</b></a>
                    <a @click.prevent="modal" class="btn_form_g"><b>취소</b></a>
                    <modals-container />
                </div>

            </div>
        </div>
    </div>
</template>
<script>

    export default {
        name: 'join',
        data() {
            return {
                context: 'http://localhost:8081/',
                userid: '',
                idCheckmsg: '',
                passwd: '',
                passwd2: '',
                passwdCheck: '비밀번호가 너무 짧습니다',
                passwdCheck2: '입력한 비밀번호가 다릅니다',
                name: '',
                email1: '',
                email2: '',
                gender: '',
                bYear: '',
                bMonth: '',
                yearcheck: '',
                monthcheck: '',
                bmsg: '',
                bmmsg: '',
                birthMonth: '',
                region: ''
            }
        },
        computed: {
            idChecklength() {
                return this.userid.length
            }
        },
        yeartrue() {
            if (this.bYear > 1900 && this.bYear < 2021) {
                return true
            } else {
                return false
            }
        },
        monthtrue() {
            if (this.bMonth < 13 && this.bMonth > 0) {
                return true
            } else {
                return false
            }
        },
        methods: {}
    }


</script>
<style scoped>
    #contents{
        float: none;
        margin: auto;
    }
    input {
        margin-right: 3px;
    }
    a {
        color:#666; text-decoration:none;
    }
    a:hover {
        color:#333; text-decoration:underline;
    }
    .t_user01 select {
        padding: 2.5px;
        padding-right: 15px;
        width:fit-content;
    }
    .btn_form_r b {
        display: inline-block;
        height: 20px;
        margin-right: 10px;
        padding: 4px 16px 1px 17px;
        background: #0d124f;
        border: 1px solid #bebebe;
        color: #fff;
    }
</style>