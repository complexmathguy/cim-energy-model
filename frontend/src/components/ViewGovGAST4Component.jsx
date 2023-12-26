import React, { Component } from 'react'
import GovGAST4Service from '../services/GovGAST4Service'

class ViewGovGAST4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGAST4: {}
        }
    }

    componentDidMount(){
        GovGAST4Service.getGovGAST4ById(this.state.id).then( res => {
            this.setState({govGAST4: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGAST4 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> bp:&emsp; </label>
                            <div> { this.state.govGAST4.bp }</div>
                        </div>
                        <div className = "row">
                            <label> ktm:&emsp; </label>
                            <div> { this.state.govGAST4.ktm }</div>
                        </div>
                        <div className = "row">
                            <label> mnef:&emsp; </label>
                            <div> { this.state.govGAST4.mnef }</div>
                        </div>
                        <div className = "row">
                            <label> mxef:&emsp; </label>
                            <div> { this.state.govGAST4.mxef }</div>
                        </div>
                        <div className = "row">
                            <label> rymn:&emsp; </label>
                            <div> { this.state.govGAST4.rymn }</div>
                        </div>
                        <div className = "row">
                            <label> rymx:&emsp; </label>
                            <div> { this.state.govGAST4.rymx }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.govGAST4.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.govGAST4.tc }</div>
                        </div>
                        <div className = "row">
                            <label> tcm:&emsp; </label>
                            <div> { this.state.govGAST4.tcm }</div>
                        </div>
                        <div className = "row">
                            <label> tm:&emsp; </label>
                            <div> { this.state.govGAST4.tm }</div>
                        </div>
                        <div className = "row">
                            <label> tv:&emsp; </label>
                            <div> { this.state.govGAST4.tv }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGAST4Component
