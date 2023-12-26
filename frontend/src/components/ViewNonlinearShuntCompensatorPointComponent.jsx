import React, { Component } from 'react'
import NonlinearShuntCompensatorPointService from '../services/NonlinearShuntCompensatorPointService'

class ViewNonlinearShuntCompensatorPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            nonlinearShuntCompensatorPoint: {}
        }
    }

    componentDidMount(){
        NonlinearShuntCompensatorPointService.getNonlinearShuntCompensatorPointById(this.state.id).then( res => {
            this.setState({nonlinearShuntCompensatorPoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View NonlinearShuntCompensatorPoint Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> b:&emsp; </label>
                            <div> { this.state.nonlinearShuntCompensatorPoint.b }</div>
                        </div>
                        <div className = "row">
                            <label> b0:&emsp; </label>
                            <div> { this.state.nonlinearShuntCompensatorPoint.b0 }</div>
                        </div>
                        <div className = "row">
                            <label> g:&emsp; </label>
                            <div> { this.state.nonlinearShuntCompensatorPoint.g }</div>
                        </div>
                        <div className = "row">
                            <label> g0:&emsp; </label>
                            <div> { this.state.nonlinearShuntCompensatorPoint.g0 }</div>
                        </div>
                        <div className = "row">
                            <label> sectionNumber:&emsp; </label>
                            <div> { this.state.nonlinearShuntCompensatorPoint.sectionNumber }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewNonlinearShuntCompensatorPointComponent
