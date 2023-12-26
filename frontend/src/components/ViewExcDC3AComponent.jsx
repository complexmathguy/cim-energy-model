import React, { Component } from 'react'
import ExcDC3AService from '../services/ExcDC3AService'

class ViewExcDC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excDC3A: {}
        }
    }

    componentDidMount(){
        ExcDC3AService.getExcDC3AById(this.state.id).then( res => {
            this.setState({excDC3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcDC3A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> edfmax:&emsp; </label>
                            <div> { this.state.excDC3A.edfmax }</div>
                        </div>
                        <div className = "row">
                            <label> efd1:&emsp; </label>
                            <div> { this.state.excDC3A.efd1 }</div>
                        </div>
                        <div className = "row">
                            <label> efd2:&emsp; </label>
                            <div> { this.state.excDC3A.efd2 }</div>
                        </div>
                        <div className = "row">
                            <label> efdlim:&emsp; </label>
                            <div> { this.state.excDC3A.efdlim }</div>
                        </div>
                        <div className = "row">
                            <label> efdmin:&emsp; </label>
                            <div> { this.state.excDC3A.efdmin }</div>
                        </div>
                        <div className = "row">
                            <label> exclim:&emsp; </label>
                            <div> { this.state.excDC3A.exclim }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excDC3A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kr:&emsp; </label>
                            <div> { this.state.excDC3A.kr }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.excDC3A.ks }</div>
                        </div>
                        <div className = "row">
                            <label> kv:&emsp; </label>
                            <div> { this.state.excDC3A.kv }</div>
                        </div>
                        <div className = "row">
                            <label> seefd1:&emsp; </label>
                            <div> { this.state.excDC3A.seefd1 }</div>
                        </div>
                        <div className = "row">
                            <label> seefd2:&emsp; </label>
                            <div> { this.state.excDC3A.seefd2 }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excDC3A.te }</div>
                        </div>
                        <div className = "row">
                            <label> trh:&emsp; </label>
                            <div> { this.state.excDC3A.trh }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excDC3A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excDC3A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcDC3AComponent
