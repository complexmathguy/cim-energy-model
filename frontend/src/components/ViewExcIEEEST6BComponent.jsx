import React, { Component } from 'react'
import ExcIEEEST6BService from '../services/ExcIEEEST6BService'

class ViewExcIEEEST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST6B: {}
        }
    }

    componentDidMount(){
        ExcIEEEST6BService.getExcIEEEST6BById(this.state.id).then( res => {
            this.setState({excIEEEST6B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST6B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ilr:&emsp; </label>
                            <div> { this.state.excIEEEST6B.ilr }</div>
                        </div>
                        <div className = "row">
                            <label> kci:&emsp; </label>
                            <div> { this.state.excIEEEST6B.kci }</div>
                        </div>
                        <div className = "row">
                            <label> kff:&emsp; </label>
                            <div> { this.state.excIEEEST6B.kff }</div>
                        </div>
                        <div className = "row">
                            <label> kg:&emsp; </label>
                            <div> { this.state.excIEEEST6B.kg }</div>
                        </div>
                        <div className = "row">
                            <label> kia:&emsp; </label>
                            <div> { this.state.excIEEEST6B.kia }</div>
                        </div>
                        <div className = "row">
                            <label> klr:&emsp; </label>
                            <div> { this.state.excIEEEST6B.klr }</div>
                        </div>
                        <div className = "row">
                            <label> km:&emsp; </label>
                            <div> { this.state.excIEEEST6B.km }</div>
                        </div>
                        <div className = "row">
                            <label> kpa:&emsp; </label>
                            <div> { this.state.excIEEEST6B.kpa }</div>
                        </div>
                        <div className = "row">
                            <label> oelin:&emsp; </label>
                            <div> { this.state.excIEEEST6B.oelin }</div>
                        </div>
                        <div className = "row">
                            <label> tg:&emsp; </label>
                            <div> { this.state.excIEEEST6B.tg }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excIEEEST6B.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excIEEEST6B.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEST6B.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEST6B.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST6BComponent
