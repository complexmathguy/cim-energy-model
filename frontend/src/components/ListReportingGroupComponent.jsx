import React, { Component } from 'react'
import ReportingGroupService from '../services/ReportingGroupService'

class ListReportingGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                reportingGroups: []
        }
        this.addReportingGroup = this.addReportingGroup.bind(this);
        this.editReportingGroup = this.editReportingGroup.bind(this);
        this.deleteReportingGroup = this.deleteReportingGroup.bind(this);
    }

    deleteReportingGroup(id){
        ReportingGroupService.deleteReportingGroup(id).then( res => {
            this.setState({reportingGroups: this.state.reportingGroups.filter(reportingGroup => reportingGroup.reportingGroupId !== id)});
        });
    }
    viewReportingGroup(id){
        this.props.history.push(`/view-reportingGroup/${id}`);
    }
    editReportingGroup(id){
        this.props.history.push(`/add-reportingGroup/${id}`);
    }

    componentDidMount(){
        ReportingGroupService.getReportingGroups().then((res) => {
            this.setState({ reportingGroups: res.data});
        });
    }

    addReportingGroup(){
        this.props.history.push('/add-reportingGroup/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ReportingGroup List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addReportingGroup}> Add ReportingGroup</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.reportingGroups.map(
                                        reportingGroup => 
                                        <tr key = {reportingGroup.reportingGroupId}>
                                             <td>
                                                 <button onClick={ () => this.editReportingGroup(reportingGroup.reportingGroupId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteReportingGroup(reportingGroup.reportingGroupId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewReportingGroup(reportingGroup.reportingGroupId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListReportingGroupComponent
