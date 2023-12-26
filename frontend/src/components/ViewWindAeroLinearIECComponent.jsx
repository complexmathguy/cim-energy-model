import React, { Component } from 'react'
import WindAeroLinearIECService from '../services/WindAeroLinearIECService'

class ViewWindAeroLinearIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windAeroLinearIEC: {}
        }
    }

    componentDidMount(){
        WindAeroLinearIECService.getWindAeroLinearIECById(this.state.id).then( res => {
            this.setState({windAeroLinearIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindAeroLinearIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dpomega:&emsp; </label>
                            <div> { this.state.windAeroLinearIEC.dpomega }</div>
                        </div>
                        <div className = "row">
                            <label> dptheta:&emsp; </label>
                            <div> { this.state.windAeroLinearIEC.dptheta }</div>
                        </div>
                        <div className = "row">
                            <label> omegazero:&emsp; </label>
                            <div> { this.state.windAeroLinearIEC.omegazero }</div>
                        </div>
                        <div className = "row">
                            <label> pavail:&emsp; </label>
                            <div> { this.state.windAeroLinearIEC.pavail }</div>
                        </div>
                        <div className = "row">
                            <label> thetazero:&emsp; </label>
                            <div> { this.state.windAeroLinearIEC.thetazero }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindAeroLinearIECComponent
