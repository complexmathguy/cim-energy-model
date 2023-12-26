import React, { Component } from 'react'
import CsConverterService from '../services/CsConverterService'

class ViewCsConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            csConverter: {}
        }
    }

    componentDidMount(){
        CsConverterService.getCsConverterById(this.state.id).then( res => {
            this.setState({csConverter: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View CsConverter Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> maxAlpha:&emsp; </label>
                            <div> { this.state.csConverter.maxAlpha }</div>
                        </div>
                        <div className = "row">
                            <label> maxGamma:&emsp; </label>
                            <div> { this.state.csConverter.maxGamma }</div>
                        </div>
                        <div className = "row">
                            <label> maxIdc:&emsp; </label>
                            <div> { this.state.csConverter.maxIdc }</div>
                        </div>
                        <div className = "row">
                            <label> minAlpha:&emsp; </label>
                            <div> { this.state.csConverter.minAlpha }</div>
                        </div>
                        <div className = "row">
                            <label> minGamma:&emsp; </label>
                            <div> { this.state.csConverter.minGamma }</div>
                        </div>
                        <div className = "row">
                            <label> minIdc:&emsp; </label>
                            <div> { this.state.csConverter.minIdc }</div>
                        </div>
                        <div className = "row">
                            <label> ratedIdc:&emsp; </label>
                            <div> { this.state.csConverter.ratedIdc }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewCsConverterComponent
