import React, { Component } from 'react'
import OverexcLimIEEEService from '../services/OverexcLimIEEEService'

class ViewOverexcLimIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            overexcLimIEEE: {}
        }
    }

    componentDidMount(){
        OverexcLimIEEEService.getOverexcLimIEEEById(this.state.id).then( res => {
            this.setState({overexcLimIEEE: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OverexcLimIEEE Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> hyst:&emsp; </label>
                            <div> { this.state.overexcLimIEEE.hyst }</div>
                        </div>
                        <div className = "row">
                            <label> ifdlim:&emsp; </label>
                            <div> { this.state.overexcLimIEEE.ifdlim }</div>
                        </div>
                        <div className = "row">
                            <label> ifdmax:&emsp; </label>
                            <div> { this.state.overexcLimIEEE.ifdmax }</div>
                        </div>
                        <div className = "row">
                            <label> itfpu:&emsp; </label>
                            <div> { this.state.overexcLimIEEE.itfpu }</div>
                        </div>
                        <div className = "row">
                            <label> kcd:&emsp; </label>
                            <div> { this.state.overexcLimIEEE.kcd }</div>
                        </div>
                        <div className = "row">
                            <label> kramp:&emsp; </label>
                            <div> { this.state.overexcLimIEEE.kramp }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOverexcLimIEEEComponent
