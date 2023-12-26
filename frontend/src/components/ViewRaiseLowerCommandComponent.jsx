import React, { Component } from 'react'
import RaiseLowerCommandService from '../services/RaiseLowerCommandService'

class ViewRaiseLowerCommandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            raiseLowerCommand: {}
        }
    }

    componentDidMount(){
        RaiseLowerCommandService.getRaiseLowerCommandById(this.state.id).then( res => {
            this.setState({raiseLowerCommand: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RaiseLowerCommand Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRaiseLowerCommandComponent
