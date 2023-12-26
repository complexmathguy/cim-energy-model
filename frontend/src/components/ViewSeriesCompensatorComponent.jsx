import React, { Component } from 'react'
import SeriesCompensatorService from '../services/SeriesCompensatorService'

class ViewSeriesCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            seriesCompensator: {}
        }
    }

    componentDidMount(){
        SeriesCompensatorService.getSeriesCompensatorById(this.state.id).then( res => {
            this.setState({seriesCompensator: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SeriesCompensator Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.seriesCompensator.r }</div>
                        </div>
                        <div className = "row">
                            <label> r0:&emsp; </label>
                            <div> { this.state.seriesCompensator.r0 }</div>
                        </div>
                        <div className = "row">
                            <label> varistorPresent:&emsp; </label>
                            <div> { this.state.seriesCompensator.varistorPresent }</div>
                        </div>
                        <div className = "row">
                            <label> varistorRatedCurrent:&emsp; </label>
                            <div> { this.state.seriesCompensator.varistorRatedCurrent }</div>
                        </div>
                        <div className = "row">
                            <label> varistorVoltageThreshold:&emsp; </label>
                            <div> { this.state.seriesCompensator.varistorVoltageThreshold }</div>
                        </div>
                        <div className = "row">
                            <label> x:&emsp; </label>
                            <div> { this.state.seriesCompensator.x }</div>
                        </div>
                        <div className = "row">
                            <label> x0:&emsp; </label>
                            <div> { this.state.seriesCompensator.x0 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSeriesCompensatorComponent
