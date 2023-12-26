import React, { Component } from 'react'
import GroundService from '../services/GroundService'

class ViewGroundComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            ground: {}
        }
    }

    componentDidMount(){
        GroundService.getGroundById(this.state.id).then( res => {
            this.setState({ground: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Ground Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGroundComponent
