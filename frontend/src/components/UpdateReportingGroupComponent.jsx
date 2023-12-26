import React, { Component } from 'react'
import ReportingGroupService from '../services/ReportingGroupService';

class UpdateReportingGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateReportingGroup = this.updateReportingGroup.bind(this);

    }

    componentDidMount(){
        ReportingGroupService.getReportingGroupById(this.state.id).then( (res) =>{
            let reportingGroup = res.data;
            this.setState({
            });
        });
    }

    updateReportingGroup = (e) => {
        e.preventDefault();
        let reportingGroup = {
            reportingGroupId: this.state.id,
        };
        console.log('reportingGroup => ' + JSON.stringify(reportingGroup));
        console.log('id => ' + JSON.stringify(this.state.id));
        ReportingGroupService.updateReportingGroup(reportingGroup).then( res => {
            this.props.history.push('/reportingGroups');
        });
    }


    cancel(){
        this.props.history.push('/reportingGroups');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ReportingGroup</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateReportingGroup}>Save</button>
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

export default UpdateReportingGroupComponent
