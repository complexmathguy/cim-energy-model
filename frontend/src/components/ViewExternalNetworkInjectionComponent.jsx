import React, { Component } from 'react'
import ExternalNetworkInjectionService from '../services/ExternalNetworkInjectionService'

class ViewExternalNetworkInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            externalNetworkInjection: {}
        }
    }

    componentDidMount(){
        ExternalNetworkInjectionService.getExternalNetworkInjectionById(this.state.id).then( res => {
            this.setState({externalNetworkInjection: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExternalNetworkInjection Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> governorSCD:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.governorSCD }</div>
                        </div>
                        <div className = "row">
                            <label> ikSecond:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.ikSecond }</div>
                        </div>
                        <div className = "row">
                            <label> maxInitialSymShCCurrent:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.maxInitialSymShCCurrent }</div>
                        </div>
                        <div className = "row">
                            <label> maxP:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.maxP }</div>
                        </div>
                        <div className = "row">
                            <label> maxQ:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.maxQ }</div>
                        </div>
                        <div className = "row">
                            <label> maxR0ToX0Ratio:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.maxR0ToX0Ratio }</div>
                        </div>
                        <div className = "row">
                            <label> maxR1ToX1Ratio:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.maxR1ToX1Ratio }</div>
                        </div>
                        <div className = "row">
                            <label> maxZ0ToZ1Ratio:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.maxZ0ToZ1Ratio }</div>
                        </div>
                        <div className = "row">
                            <label> minInitialSymShCCurrent:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.minInitialSymShCCurrent }</div>
                        </div>
                        <div className = "row">
                            <label> minP:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.minP }</div>
                        </div>
                        <div className = "row">
                            <label> minQ:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.minQ }</div>
                        </div>
                        <div className = "row">
                            <label> minR0ToX0Ratio:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.minR0ToX0Ratio }</div>
                        </div>
                        <div className = "row">
                            <label> minR1ToX1Ratio:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.minR1ToX1Ratio }</div>
                        </div>
                        <div className = "row">
                            <label> minZ0ToZ1Ratio:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.minZ0ToZ1Ratio }</div>
                        </div>
                        <div className = "row">
                            <label> voltageFactor:&emsp; </label>
                            <div> { this.state.externalNetworkInjection.voltageFactor }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExternalNetworkInjectionComponent
