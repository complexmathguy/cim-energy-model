import React, { Component } from 'react'
import NonConformLoadGroupService from '../services/NonConformLoadGroupService'

class ViewNonConformLoadGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            nonConformLoadGroup: {}
        }
    }

    componentDidMount(){
        NonConformLoadGroupService.getNonConformLoadGroupById(this.state.id).then( res => {
            this.setState({nonConformLoadGroup: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View NonConformLoadGroup Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewNonConformLoadGroupComponent
