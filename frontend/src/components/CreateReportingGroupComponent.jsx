import React, { Component } from 'react'
import ReportingGroupService from '../services/ReportingGroupService';

class CreateReportingGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ReportingGroupService.getReportingGroupById(this.state.id).then( (res) =>{
                let reportingGroup = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateReportingGroup = (e) => {
        e.preventDefault();
        let reportingGroup = {
                reportingGroupId: this.state.id,
            };
        console.log('reportingGroup => ' + JSON.stringify(reportingGroup));

        // step 5
        if(this.state.id === '_add'){
            reportingGroup.reportingGroupId=''
            ReportingGroupService.createReportingGroup(reportingGroup).then(res =>{
                this.props.history.push('/reportingGroups');
            });
        }else{
            ReportingGroupService.updateReportingGroup(reportingGroup).then( res => {
                this.props.history.push('/reportingGroups');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/reportingGroups');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ReportingGroup</h3>
        }else{
            return <h3 className="text-center">Update ReportingGroup</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateReportingGroup}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateReportingGroupComponent
