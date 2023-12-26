import React, { Component } from 'react'
import ConformLoadGroupService from '../services/ConformLoadGroupService'

class ViewConformLoadGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            conformLoadGroup: {}
        }
    }

    componentDidMount(){
        ConformLoadGroupService.getConformLoadGroupById(this.state.id).then( res => {
            this.setState({conformLoadGroup: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ConformLoadGroup Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewConformLoadGroupComponent
