import React, { Component } from 'react'
import DCLineService from '../services/DCLineService'

class ViewDCLineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCLine: {}
        }
    }

    componentDidMount(){
        DCLineService.getDCLineById(this.state.id).then( res => {
            this.setState({dCLine: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCLine Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCLineComponent
