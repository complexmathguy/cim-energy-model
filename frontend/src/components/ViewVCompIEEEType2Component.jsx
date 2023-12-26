import React, { Component } from 'react'
import VCompIEEEType2Service from '../services/VCompIEEEType2Service'

class ViewVCompIEEEType2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            vCompIEEEType2: {}
        }
    }

    componentDidMount(){
        VCompIEEEType2Service.getVCompIEEEType2ById(this.state.id).then( res => {
            this.setState({vCompIEEEType2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VCompIEEEType2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> tr:&emsp; </label>
                            <div> { this.state.vCompIEEEType2.tr }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVCompIEEEType2Component
