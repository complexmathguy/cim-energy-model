import React, { Component } from 'react'
import PssSB4Service from '../services/PssSB4Service'

class ViewPssSB4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssSB4: {}
        }
    }

    componentDidMount(){
        PssSB4Service.getPssSB4ById(this.state.id).then( res => {
            this.setState({pssSB4: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssSB4 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kx:&emsp; </label>
                            <div> { this.state.pssSB4.kx }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.pssSB4.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.pssSB4.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.pssSB4.tc }</div>
                        </div>
                        <div className = "row">
                            <label> td:&emsp; </label>
                            <div> { this.state.pssSB4.td }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.pssSB4.te }</div>
                        </div>
                        <div className = "row">
                            <label> tt:&emsp; </label>
                            <div> { this.state.pssSB4.tt }</div>
                        </div>
                        <div className = "row">
                            <label> tx1:&emsp; </label>
                            <div> { this.state.pssSB4.tx1 }</div>
                        </div>
                        <div className = "row">
                            <label> tx2:&emsp; </label>
                            <div> { this.state.pssSB4.tx2 }</div>
                        </div>
                        <div className = "row">
                            <label> vsmax:&emsp; </label>
                            <div> { this.state.pssSB4.vsmax }</div>
                        </div>
                        <div className = "row">
                            <label> vsmin:&emsp; </label>
                            <div> { this.state.pssSB4.vsmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssSB4Component
