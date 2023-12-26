import React, { Component } from 'react'
import LineService from '../services/LineService'

class ViewLineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            line: {}
        }
    }

    componentDidMount(){
        LineService.getLineById(this.state.id).then( res => {
            this.setState({line: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Line Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLineComponent
