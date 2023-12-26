import React, { Component } from 'react'
import MechLoad1Service from '../services/MechLoad1Service'

class ViewMechLoad1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            mechLoad1: {}
        }
    }

    componentDidMount(){
        MechLoad1Service.getMechLoad1ById(this.state.id).then( res => {
            this.setState({mechLoad1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View MechLoad1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> a:&emsp; </label>
                            <div> { this.state.mechLoad1.a }</div>
                        </div>
                        <div className = "row">
                            <label> b:&emsp; </label>
                            <div> { this.state.mechLoad1.b }</div>
                        </div>
                        <div className = "row">
                            <label> d:&emsp; </label>
                            <div> { this.state.mechLoad1.d }</div>
                        </div>
                        <div className = "row">
                            <label> e:&emsp; </label>
                            <div> { this.state.mechLoad1.e }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMechLoad1Component
