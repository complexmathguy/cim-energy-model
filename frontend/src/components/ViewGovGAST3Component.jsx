import React, { Component } from 'react'
import GovGAST3Service from '../services/GovGAST3Service'

class ViewGovGAST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGAST3: {}
        }
    }

    componentDidMount(){
        GovGAST3Service.getGovGAST3ById(this.state.id).then( res => {
            this.setState({govGAST3: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGAST3 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> bca:&emsp; </label>
                            <div> { this.state.govGAST3.bca }</div>
                        </div>
                        <div className = "row">
                            <label> bp:&emsp; </label>
                            <div> { this.state.govGAST3.bp }</div>
                        </div>
                        <div className = "row">
                            <label> dtc:&emsp; </label>
                            <div> { this.state.govGAST3.dtc }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.govGAST3.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kac:&emsp; </label>
                            <div> { this.state.govGAST3.kac }</div>
                        </div>
                        <div className = "row">
                            <label> kca:&emsp; </label>
                            <div> { this.state.govGAST3.kca }</div>
                        </div>
                        <div className = "row">
                            <label> ksi:&emsp; </label>
                            <div> { this.state.govGAST3.ksi }</div>
                        </div>
                        <div className = "row">
                            <label> ky:&emsp; </label>
                            <div> { this.state.govGAST3.ky }</div>
                        </div>
                        <div className = "row">
                            <label> mnef:&emsp; </label>
                            <div> { this.state.govGAST3.mnef }</div>
                        </div>
                        <div className = "row">
                            <label> mxef:&emsp; </label>
                            <div> { this.state.govGAST3.mxef }</div>
                        </div>
                        <div className = "row">
                            <label> rcmn:&emsp; </label>
                            <div> { this.state.govGAST3.rcmn }</div>
                        </div>
                        <div className = "row">
                            <label> rcmx:&emsp; </label>
                            <div> { this.state.govGAST3.rcmx }</div>
                        </div>
                        <div className = "row">
                            <label> tac:&emsp; </label>
                            <div> { this.state.govGAST3.tac }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.govGAST3.tc }</div>
                        </div>
                        <div className = "row">
                            <label> td:&emsp; </label>
                            <div> { this.state.govGAST3.td }</div>
                        </div>
                        <div className = "row">
                            <label> tfen:&emsp; </label>
                            <div> { this.state.govGAST3.tfen }</div>
                        </div>
                        <div className = "row">
                            <label> tg:&emsp; </label>
                            <div> { this.state.govGAST3.tg }</div>
                        </div>
                        <div className = "row">
                            <label> tsi:&emsp; </label>
                            <div> { this.state.govGAST3.tsi }</div>
                        </div>
                        <div className = "row">
                            <label> tt:&emsp; </label>
                            <div> { this.state.govGAST3.tt }</div>
                        </div>
                        <div className = "row">
                            <label> ttc:&emsp; </label>
                            <div> { this.state.govGAST3.ttc }</div>
                        </div>
                        <div className = "row">
                            <label> ty:&emsp; </label>
                            <div> { this.state.govGAST3.ty }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGAST3Component
