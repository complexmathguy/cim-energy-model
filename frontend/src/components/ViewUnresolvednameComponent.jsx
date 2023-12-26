import React, { Component } from 'react'
import UnresolvednameService from '../services/UnresolvednameService'

class ViewUnresolvednameComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            unresolvedname: {}
        }
    }

    componentDidMount(){
        UnresolvednameService.getUnresolvednameById(this.state.id).then( res => {
            this.setState({unresolvedname: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Unresolvedname Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewUnresolvednameComponent
