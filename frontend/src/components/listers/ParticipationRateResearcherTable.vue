<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="values"
                :items-per-page="5"
                class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-fab-transition>
                            <v-btn
                                    color="primary"
                                    fab
                                    dark
                                    large
                                    style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                                    @click="openDialog=true;"
                            >
                                <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                            </v-btn>
                        </v-fab-transition>
                    </template>

                    <ParticipationRateResearcher :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                    <v-btn
                            style="postition:absolute; top:2%; right:2%"
                            @click="closeDialog()"
                            depressed 
                            icon 
                            absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
    const axios = require('axios').default;
    import ParticipationRateResearcher from './../ParticipationRateResearcher.vue';

    export default {
        name: 'ParticipationRateResearcherManager',
        components: {
            ParticipationRateResearcher,
        },
        props: {
            offline: Boolean,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            values: [],
            headers: 
                [
                    { text: "name", value: "name" },
                    { text: "role", value: "role" },
                    { text: "residentId", value: "residentId" },
                    { text: "phoneNumber", value: "phoneNumber" },
                    { text: "highestEducation", value: "highestEducation" },
                    { text: "highestEducationSchool", value: "highestEducationSchool" },
                    { text: "highestEducationMajor", value: "highestEducationMajor" },
                    { text: "monthlySalary", value: "monthlySalary" },
                    { text: "physicalAllowanceRate", value: "physicalAllowanceRate" },
                    { text: "cashAllowanceRate", value: "cashAllowanceRate" },
                    { text: "duration", value: "duration" },
                    { text: "department", value: "department" },
                    { text: "researcherNumber", value: "researcherNumber" },
                    { text: "projectMasterId", value: "projectMasterId" },
                ],
            researcher : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/researchers'))
            temp.data._embedded.researchers.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.researchers;

            this.newValue = {
                'name': '',
                'role': '',
                'residentId': '',
                'phoneNumber': '',
                'highestEducation': '',
                'highestEducationSchool': '',
                'highestEducationMajor': '',
                'monthlySalary': '',
                'physicalAllowanceRate': 0,
                'cashAllowanceRate': 0,
                'duration': 0,
                'department': '',
                'researcherNumber': '',
                'projectMasterId': {},
            }
        },
        methods: {
            closeDialog(){
                this.openDialog = false
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                
                this.$emit('input', this.values);

                this.$nextTick(function(){
                    this.tick=true
                })
            },
        }
    }
</script>

