import React, { Component } from 'react'
import JunctionService from '../services/JunctionService'

class ViewJunctionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            junction: {}
        }
    }

    componentDidMount(){
        JunctionService.getJunctionById(this.state.id).then( res => {
            this.setState({junction: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Junction Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewJunctionComponent
