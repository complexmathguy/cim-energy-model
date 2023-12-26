import React, { Component } from 'react'
import WindContPType4bIECService from '../services/WindContPType4bIECService'

class ViewWindContPType4bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContPType4bIEC: {}
        }
    }

    componentDidMount(){
        WindContPType4bIECService.getWindContPType4bIECById(this.state.id).then( res => {
            this.setState({windContPType4bIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContPType4bIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dpmax:&emsp; </label>
                            <div> { this.state.windContPType4bIEC.dpmax }</div>
                        </div>
                        <div className = "row">
                            <label> tpaero:&emsp; </label>
                            <div> { this.state.windContPType4bIEC.tpaero }</div>
                        </div>
                        <div className = "row">
                            <label> tpord:&emsp; </label>
                            <div> { this.state.windContPType4bIEC.tpord }</div>
                        </div>
                        <div className = "row">
                            <label> tufilt:&emsp; </label>
                            <div> { this.state.windContPType4bIEC.tufilt }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContPType4bIECComponent
