import React, { Component } from 'react'
import WindContPType4aIECService from '../services/WindContPType4aIECService'

class ViewWindContPType4aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContPType4aIEC: {}
        }
    }

    componentDidMount(){
        WindContPType4aIECService.getWindContPType4aIECById(this.state.id).then( res => {
            this.setState({windContPType4aIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContPType4aIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dpmax:&emsp; </label>
                            <div> { this.state.windContPType4aIEC.dpmax }</div>
                        </div>
                        <div className = "row">
                            <label> tpord:&emsp; </label>
                            <div> { this.state.windContPType4aIEC.tpord }</div>
                        </div>
                        <div className = "row">
                            <label> tufilt:&emsp; </label>
                            <div> { this.state.windContPType4aIEC.tufilt }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContPType4aIECComponent
