import React, { Component } from 'react'
import LoadAreaService from '../services/LoadAreaService'

class ViewLoadAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadArea: {}
        }
    }

    componentDidMount(){
        LoadAreaService.getLoadAreaById(this.state.id).then( res => {
            this.setState({loadArea: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadArea Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadAreaComponent
