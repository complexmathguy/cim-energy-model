import React, { Component } from 'react'
import SynchronousMachineDetailedService from '../services/SynchronousMachineDetailedService'

class ViewSynchronousMachineDetailedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            synchronousMachineDetailed: {}
        }
    }

    componentDidMount(){
        SynchronousMachineDetailedService.getSynchronousMachineDetailedById(this.state.id).then( res => {
            this.setState({synchronousMachineDetailed: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SynchronousMachineDetailed Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efdBaseRatio:&emsp; </label>
                            <div> { this.state.synchronousMachineDetailed.efdBaseRatio }</div>
                        </div>
                        <div className = "row">
                            <label> ifdBaseType:&emsp; </label>
                            <div> { this.state.synchronousMachineDetailed.ifdBaseType }</div>
                        </div>
                        <div className = "row">
                            <label> ifdBaseValue:&emsp; </label>
                            <div> { this.state.synchronousMachineDetailed.ifdBaseValue }</div>
                        </div>
                        <div className = "row">
                            <label> saturationFactor120QAxis:&emsp; </label>
                            <div> { this.state.synchronousMachineDetailed.saturationFactor120QAxis }</div>
                        </div>
                        <div className = "row">
                            <label> saturationFactorQAxis:&emsp; </label>
                            <div> { this.state.synchronousMachineDetailed.saturationFactorQAxis }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSynchronousMachineDetailedComponent
