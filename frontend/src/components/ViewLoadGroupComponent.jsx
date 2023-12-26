import React, { Component } from 'react'
import LoadGroupService from '../services/LoadGroupService'

class ViewLoadGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadGroup: {}
        }
    }

    componentDidMount(){
        LoadGroupService.getLoadGroupById(this.state.id).then( res => {
            this.setState({loadGroup: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadGroup Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadGroupComponent
