<template>
    <v-card style="width:450px; height:100%;" outlined>
        <template slot="progress">
            <v-progress-linear
                    color="primary-darker-1"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

        <v-card-title v-if="value._links">
            결의 # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            결의
        </v-card-title >        

        <v-card-text>
            <String v-if="editMode" label="결의번호" v-model="value.resolutionNumber" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="비목" v-model="value.directOrIndirectExpense" :editMode="editMode" :inputUI="'SELECT'"/>
            <String label="세목" v-model="value.item" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="결의명" v-model="value.resolutionName" :editMode="editMode" :inputUI="'TEXT'"/>
            <Money offline label="결의공급가액" v-model="value.totalAmount" :editMode="editMode" @change="change"/>
            <String label="지급처명" v-model="value.vendorName" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="은행명" v-model="value.bankName" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="은행계좌번호" v-model="value.bankAccountNumber" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="예금주" v-model="value.accountOwner" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="결의내용" v-model="value.resolutionContent" :editMode="editMode" :inputUI="'TEXTAREA'"/>
            <FileManager offline label="붙임파일" v-model="value.attachments" :editMode="editMode" @change="change"/>
            <String label="결재상태" v-model="value.approvalStatus" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="결재선" v-model="value.approvalLine" :editMode="editMode" :inputUI="'TEXT'"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                color="primary"
                text
                @click="edit"
                v-if="!editMode"
            >
                수정
            </v-btn>
            <div v-else>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    결의 생성
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    결의 삭제
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
                >
                    삭제
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode && !isNew"
                >
                    취소
                </v-btn>
            </div>
        </v-card-actions>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openUpdateExpenseResolution"
            >
                UpdateExpenseResolution
            </v-btn>
            <v-dialog v-model="updateExpenseResolutionDiagram" width="500">
                <UpdateExpenseResolutionCommand
                    @closeDialog="closeUpdateExpenseResolution"
                    @updateExpenseResolution="updateExpenseResolution"
                ></UpdateExpenseResolutionCommand>
            </v-dialog>
        </v-card-actions>

        <v-snackbar
            v-model="snackbar.status"
            :top="true"
            :timeout="snackbar.timeout"
            color="error"
        >
            {{ snackbar.text }}
            <v-btn dark text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
    </v-card>

</template>

<script>
    const axios = require('axios').default;

    import Money from './vo/Money.vue';

    export default {
        name: '집행ExpenseResolution',
        components:{
            Money,
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
        },
        data: () => ({
            snackbar: {
                status: false,
                timeout: 5000,
                text: '',
            },
            updateExpenseResolutionDiagram: false,
        }),
	async created() {
        },
        methods: {
            decode(value) {
                return decodeURIComponent(value);
            },
            selectFile(){
                if(this.editMode == false) {
                    return false;
                }
                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.imageUrl = result;
                        me.value.photo = result;
                        
                    };
                    reader.readAsDataURL( file );
                };
            },
            edit() {
                this.editMode = true;
            },
            async save(){
                try {
                    var temp = null;

                    if(!this.offline) {
                        if(this.isNew) {
                            temp = await axios.post(axios.fixUrl('/expenseResolutions'), this.value)
                        } else {
                            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
                        }
                    }

                    if(this.value!=null) {
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    } else {
                        this.value = temp.data;
                    }

                    this.editMode = false;
                    this.$emit('input', this.value);

                    if (this.isNew) {
                        this.$emit('add', this.value);
                    } else {
                        this.$emit('edit', this.value);
                    }

                    location.reload()

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
                
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links.self.href))
                    }

                    this.editMode = false;
                    this.isDeleted = true;

                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            change(){
                this.$emit('input', this.value);
            },
            async updateExpenseResolution(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links['/resolutions/{resolutionNumber}'].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeUpdateExpenseResolution();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openUpdateExpenseResolution() {
                this.updateExpenseResolutionDiagram = true;
            },
            closeUpdateExpenseResolution() {
                this.updateExpenseResolutionDiagram = false;
            },
        },
    }
</script>

