import React, { Component } from 'react'
import WindMechIECService from '../services/WindMechIECService'

class ViewWindMechIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windMechIEC: {}
        }
    }

    componentDidMount(){
        WindMechIECService.getWindMechIECById(this.state.id).then( res => {
            this.setState({windMechIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindMechIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> cdrt:&emsp; </label>
                            <div> { this.state.windMechIEC.cdrt }</div>
                        </div>
                        <div className = "row">
                            <label> hgen:&emsp; </label>
                            <div> { this.state.windMechIEC.hgen }</div>
                        </div>
                        <div className = "row">
                            <label> hwtr:&emsp; </label>
                            <div> { this.state.windMechIEC.hwtr }</div>
                        </div>
                        <div className = "row">
                            <label> kdrt:&emsp; </label>
                            <div> { this.state.windMechIEC.kdrt }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindMechIECComponent
