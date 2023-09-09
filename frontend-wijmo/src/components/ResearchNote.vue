<template>
    <div>
        <String label="과제관리번호" v-model="value.researchNoteId" :editMode="editMode"/>
        <Date label="일자" v-model="value.date" :editMode="editMode"/>
        <String label="작성자" v-model="value.author" :editMode="editMode"/>
        <String label="내용" v-model="value.content" :editMode="editMode"/>
        <String label="서명" v-model="value.signature" :editMode="editMode"/>
        <String label="결재상태" v-model="value.approvalStatus" :editMode="editMode"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'ResearchNote',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "researchNotes"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

