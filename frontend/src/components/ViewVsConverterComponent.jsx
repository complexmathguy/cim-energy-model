import React, { Component } from 'react'
import VsConverterService from '../services/VsConverterService'

class ViewVsConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            vsConverter: {}
        }
    }

    componentDidMount(){
        VsConverterService.getVsConverterById(this.state.id).then( res => {
            this.setState({vsConverter: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VsConverter Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> maxModulationIndex:&emsp; </label>
                            <div> { this.state.vsConverter.maxModulationIndex }</div>
                        </div>
                        <div className = "row">
                            <label> maxValveCurrent:&emsp; </label>
                            <div> { this.state.vsConverter.maxValveCurrent }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVsConverterComponent
