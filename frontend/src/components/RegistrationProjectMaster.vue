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
            과제 마스터 # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            과제 마스터
        </v-card-title >        

        <v-card-text>
            <String v-if="editMode" label="ProjectId" v-model="value.projectId" :editMode="editMode" :inputUI="''"/>
            <String label="공고 사업명" v-model="value.noticeProjectName" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="사업 담당자" v-model="value.projectManager" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="과제명" v-model="value.projectName" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="RFP명" v-model="value.rfpName" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="연구 책임자" v-model="value.researchManager" :editMode="editMode" :inputUI="'TEXT'"/>
            <Boolean label="현금 부담 여부" v-model="value.cashBurden" :editMode="editMode" :inputUI="'SELECT'"/>
            <Boolean label="현물 부담 여부" v-model="value.materialBurden" :editMode="editMode" :inputUI="'SELECT'"/>
            <Number label="총 사업 비용" v-model="value.totalProjectCost" :editMode="editMode" :inputUI="'TEXT'"/>
            <Number label="당해년도 사업 비용" v-model="value.currentYearProjectCost" :editMode="editMode" :inputUI="'TEXT'"/>
            <Number label="총 기간(개월)" v-model="value.totalProjectDuration" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="당해년도 기간" v-model="value.currentYearDuration" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="주관 기관명" v-model="value.organName" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="주관 기관 사업자 번호" v-model="value.organBusinessNumber" :editMode="editMode" :inputUI="'TEXT'"/>
            <String label="주관 기관 총 책임자" v-model="value.organDirector" :editMode="editMode" :inputUI="'TEXT'"/>
            <Date label="접수일" v-model="value.receiptDate" :editMode="editMode" :inputUI="''"/>
            <Boolean label="선정 통보 완료 여부" v-model="value.selectionNotification" :editMode="editMode" :inputUI="'SELECT'"/>
            <Boolean label="계정 부여 여부" v-model="value.accountAllocation" :editMode="editMode" :inputUI="'SELECT'"/>
            <File offline label="사업 계획서 파일" v-model="value.projectPlanFile" :editMode="editMode" @change="change"/>
            <ParticipationType offline label="ParticipationType" v-model="value.participationType" :editMode="editMode" @change="change"/>
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
                    프로젝트 생성
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    프로젝트 삭제
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
                @click="openUpdateProject"
            >
                UpdateProject
            </v-btn>
            <v-dialog v-model="updateProjectDiagram" width="500">
                <UpdateProjectCommand
                    @closeDialog="closeUpdateProject"
                    @updateProject="updateProject"
                ></UpdateProjectCommand>
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


    export default {
        name: 'RegistrationProjectMaster',
        components:{
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
            updateProjectDiagram: false,
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
                            temp = await axios.post(axios.fixUrl('/projectMasters'), this.value)
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
            async updateProject(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links['/projects/{projectId}'].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeUpdateProject();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openUpdateProject() {
                this.updateProjectDiagram = true;
            },
            closeUpdateProject() {
                this.updateProjectDiagram = false;
            },
        },
    }
</script>

