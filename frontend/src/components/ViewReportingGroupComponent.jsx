import React, { Component } from 'react'
import ReportingGroupService from '../services/ReportingGroupService'

class ViewReportingGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            reportingGroup: {}
        }
    }

    componentDidMount(){
        ReportingGroupService.getReportingGroupById(this.state.id).then( res => {
            this.setState({reportingGroup: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ReportingGroup Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewReportingGroupComponent
