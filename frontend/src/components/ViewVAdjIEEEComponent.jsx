import React, { Component } from 'react'
import VAdjIEEEService from '../services/VAdjIEEEService'

class ViewVAdjIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            vAdjIEEE: {}
        }
    }

    componentDidMount(){
        VAdjIEEEService.getVAdjIEEEById(this.state.id).then( res => {
            this.setState({vAdjIEEE: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VAdjIEEE Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> adjslew:&emsp; </label>
                            <div> { this.state.vAdjIEEE.adjslew }</div>
                        </div>
                        <div className = "row">
                            <label> taoff:&emsp; </label>
                            <div> { this.state.vAdjIEEE.taoff }</div>
                        </div>
                        <div className = "row">
                            <label> taon:&emsp; </label>
                            <div> { this.state.vAdjIEEE.taon }</div>
                        </div>
                        <div className = "row">
                            <label> vadjf:&emsp; </label>
                            <div> { this.state.vAdjIEEE.vadjf }</div>
                        </div>
                        <div className = "row">
                            <label> vadjmax:&emsp; </label>
                            <div> { this.state.vAdjIEEE.vadjmax }</div>
                        </div>
                        <div className = "row">
                            <label> vadjmin:&emsp; </label>
                            <div> { this.state.vAdjIEEE.vadjmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVAdjIEEEComponent
