import React, { Component } from 'react'
import GovGASTService from '../services/GovGASTService'

class ViewGovGASTComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGAST: {}
        }
    }

    componentDidMount(){
        GovGASTService.getGovGASTById(this.state.id).then( res => {
            this.setState({govGAST: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGAST Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> at:&emsp; </label>
                            <div> { this.state.govGAST.at }</div>
                        </div>
                        <div className = "row">
                            <label> dturb:&emsp; </label>
                            <div> { this.state.govGAST.dturb }</div>
                        </div>
                        <div className = "row">
                            <label> kt:&emsp; </label>
                            <div> { this.state.govGAST.kt }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govGAST.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.govGAST.r }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.govGAST.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.govGAST.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govGAST.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> vmax:&emsp; </label>
                            <div> { this.state.govGAST.vmax }</div>
                        </div>
                        <div className = "row">
                            <label> vmin:&emsp; </label>
                            <div> { this.state.govGAST.vmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGASTComponent
