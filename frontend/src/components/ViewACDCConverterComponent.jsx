import React, { Component } from 'react'
import ACDCConverterService from '../services/ACDCConverterService'

class ViewACDCConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            aCDCConverter: {}
        }
    }

    componentDidMount(){
        ACDCConverterService.getACDCConverterById(this.state.id).then( res => {
            this.setState({aCDCConverter: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ACDCConverter Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> baseS:&emsp; </label>
                            <div> { this.state.aCDCConverter.baseS }</div>
                        </div>
                        <div className = "row">
                            <label> idleLoss:&emsp; </label>
                            <div> { this.state.aCDCConverter.idleLoss }</div>
                        </div>
                        <div className = "row">
                            <label> maxUdc:&emsp; </label>
                            <div> { this.state.aCDCConverter.maxUdc }</div>
                        </div>
                        <div className = "row">
                            <label> minUdc:&emsp; </label>
                            <div> { this.state.aCDCConverter.minUdc }</div>
                        </div>
                        <div className = "row">
                            <label> numberOfValves:&emsp; </label>
                            <div> { this.state.aCDCConverter.numberOfValves }</div>
                        </div>
                        <div className = "row">
                            <label> ratedUdc:&emsp; </label>
                            <div> { this.state.aCDCConverter.ratedUdc }</div>
                        </div>
                        <div className = "row">
                            <label> resistiveLoss:&emsp; </label>
                            <div> { this.state.aCDCConverter.resistiveLoss }</div>
                        </div>
                        <div className = "row">
                            <label> switchingLoss:&emsp; </label>
                            <div> { this.state.aCDCConverter.switchingLoss }</div>
                        </div>
                        <div className = "row">
                            <label> valveU0:&emsp; </label>
                            <div> { this.state.aCDCConverter.valveU0 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewACDCConverterComponent
