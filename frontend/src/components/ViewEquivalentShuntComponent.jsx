import React, { Component } from 'react'
import EquivalentShuntService from '../services/EquivalentShuntService'

class ViewEquivalentShuntComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equivalentShunt: {}
        }
    }

    componentDidMount(){
        EquivalentShuntService.getEquivalentShuntById(this.state.id).then( res => {
            this.setState({equivalentShunt: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquivalentShunt Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> b:&emsp; </label>
                            <div> { this.state.equivalentShunt.b }</div>
                        </div>
                        <div className = "row">
                            <label> g:&emsp; </label>
                            <div> { this.state.equivalentShunt.g }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquivalentShuntComponent
