import React, { Component } from 'react'
import WindProtectionIECService from '../services/WindProtectionIECService'

class ViewWindProtectionIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windProtectionIEC: {}
        }
    }

    componentDidMount(){
        WindProtectionIECService.getWindProtectionIECById(this.state.id).then( res => {
            this.setState({windProtectionIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindProtectionIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> fover:&emsp; </label>
                            <div> { this.state.windProtectionIEC.fover }</div>
                        </div>
                        <div className = "row">
                            <label> funder:&emsp; </label>
                            <div> { this.state.windProtectionIEC.funder }</div>
                        </div>
                        <div className = "row">
                            <label> tfover:&emsp; </label>
                            <div> { this.state.windProtectionIEC.tfover }</div>
                        </div>
                        <div className = "row">
                            <label> tfunder:&emsp; </label>
                            <div> { this.state.windProtectionIEC.tfunder }</div>
                        </div>
                        <div className = "row">
                            <label> tuover:&emsp; </label>
                            <div> { this.state.windProtectionIEC.tuover }</div>
                        </div>
                        <div className = "row">
                            <label> tuunder:&emsp; </label>
                            <div> { this.state.windProtectionIEC.tuunder }</div>
                        </div>
                        <div className = "row">
                            <label> uover:&emsp; </label>
                            <div> { this.state.windProtectionIEC.uover }</div>
                        </div>
                        <div className = "row">
                            <label> uunder:&emsp; </label>
                            <div> { this.state.windProtectionIEC.uunder }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindProtectionIECComponent
