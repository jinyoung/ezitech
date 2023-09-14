<template>
    <v-card outlined>
        <v-card-title>
            UpdateExpenseResolution
        </v-card-title>

        <v-card-text>
            <String label="ResolutionNumber" v-model="value.resolutionNumber" :editMode="editMode"/>
            <String label="DirectOrIndirectExpense" v-model="value.directOrIndirectExpense" :editMode="editMode"/>
            <String label="Item" v-model="value.item" :editMode="editMode"/>
            <String label="ResolutionName" v-model="value.resolutionName" :editMode="editMode"/>
            <Money offline label="TotalAmount" v-model="value.totalAmount" :editMode="editMode" @change="change"/>
            <String label="VendorName" v-model="value.vendorName" :editMode="editMode"/>
            <String label="BankName" v-model="value.bankName" :editMode="editMode"/>
            <String label="BankAccountNumber" v-model="value.bankAccountNumber" :editMode="editMode"/>
            <String label="AccountOwner" v-model="value.accountOwner" :editMode="editMode"/>
            <String label="ResolutionContent" v-model="value.resolutionContent" :editMode="editMode"/>
            <FileList offline label="Attachments" v-model="value.attachments" :editMode="editMode" @change="change"/>
            <String label="ApprovalStatus" v-model="value.approvalStatus" :editMode="editMode"/>
            <String label="ApprovalLine" v-model="value.approvalLine" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateExpenseResolution"
            >
                UpdateExpenseResolution
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'UpdateExpenseResolutionCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.resolutionNumber = '';
            this.value.directOrIndirectExpense = '';
            this.value.item = '';
            this.value.resolutionName = '';
            this.value.totalAmount = {};
            this.value.vendorName = '';
            this.value.bankName = '';
            this.value.bankAccountNumber = '';
            this.value.accountOwner = '';
            this.value.resolutionContent = '';
            this.value.attachments = [];
            this.value.approvalStatus = '';
            this.value.approvalLine = '';
        },
        watch: {
        },
        methods: {
            updateExpenseResolution() {
                this.$emit('updateExpenseResolution', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

