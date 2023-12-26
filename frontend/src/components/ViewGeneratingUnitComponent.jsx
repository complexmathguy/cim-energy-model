import React, { Component } from 'react'
import GeneratingUnitService from '../services/GeneratingUnitService'

class ViewGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            generatingUnit: {}
        }
    }

    componentDidMount(){
        GeneratingUnitService.getGeneratingUnitById(this.state.id).then( res => {
            this.setState({generatingUnit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GeneratingUnit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> genControlSource:&emsp; </label>
                            <div> { this.state.generatingUnit.genControlSource }</div>
                        </div>
                        <div className = "row">
                            <label> governorSCD:&emsp; </label>
                            <div> { this.state.generatingUnit.governorSCD }</div>
                        </div>
                        <div className = "row">
                            <label> initialP:&emsp; </label>
                            <div> { this.state.generatingUnit.initialP }</div>
                        </div>
                        <div className = "row">
                            <label> longPF:&emsp; </label>
                            <div> { this.state.generatingUnit.longPF }</div>
                        </div>
                        <div className = "row">
                            <label> maximumAllowableSpinningReserve:&emsp; </label>
                            <div> { this.state.generatingUnit.maximumAllowableSpinningReserve }</div>
                        </div>
                        <div className = "row">
                            <label> maxOperatingP:&emsp; </label>
                            <div> { this.state.generatingUnit.maxOperatingP }</div>
                        </div>
                        <div className = "row">
                            <label> minOperatingP:&emsp; </label>
                            <div> { this.state.generatingUnit.minOperatingP }</div>
                        </div>
                        <div className = "row">
                            <label> nominalP:&emsp; </label>
                            <div> { this.state.generatingUnit.nominalP }</div>
                        </div>
                        <div className = "row">
                            <label> ratedGrossMaxP:&emsp; </label>
                            <div> { this.state.generatingUnit.ratedGrossMaxP }</div>
                        </div>
                        <div className = "row">
                            <label> ratedGrossMinP:&emsp; </label>
                            <div> { this.state.generatingUnit.ratedGrossMinP }</div>
                        </div>
                        <div className = "row">
                            <label> ratedNetMaxP:&emsp; </label>
                            <div> { this.state.generatingUnit.ratedNetMaxP }</div>
                        </div>
                        <div className = "row">
                            <label> shortPF:&emsp; </label>
                            <div> { this.state.generatingUnit.shortPF }</div>
                        </div>
                        <div className = "row">
                            <label> startupCost:&emsp; </label>
                            <div> { this.state.generatingUnit.startupCost }</div>
                        </div>
                        <div className = "row">
                            <label> totalEfficiency:&emsp; </label>
                            <div> { this.state.generatingUnit.totalEfficiency }</div>
                        </div>
                        <div className = "row">
                            <label> variableCost:&emsp; </label>
                            <div> { this.state.generatingUnit.variableCost }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGeneratingUnitComponent
