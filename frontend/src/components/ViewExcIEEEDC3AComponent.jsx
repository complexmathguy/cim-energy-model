import React, { Component } from 'react'
import ExcIEEEDC3AService from '../services/ExcIEEEDC3AService'

class ViewExcIEEEDC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEDC3A: {}
        }
    }

    componentDidMount(){
        ExcIEEEDC3AService.getExcIEEEDC3AById(this.state.id).then( res => {
            this.setState({excIEEEDC3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEDC3A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efd1:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.efd1 }</div>
                        </div>
                        <div className = "row">
                            <label> efd2:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.efd2 }</div>
                        </div>
                        <div className = "row">
                            <label> exclim:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.exclim }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kv:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.kv }</div>
                        </div>
                        <div className = "row">
                            <label> seefd1:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.seefd1 }</div>
                        </div>
                        <div className = "row">
                            <label> seefd2:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.seefd2 }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.te }</div>
                        </div>
                        <div className = "row">
                            <label> trh:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.trh }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEDC3A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEDC3AComponent
