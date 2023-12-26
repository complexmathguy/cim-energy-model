import React, { Component } from 'react'
import SvStatusService from '../services/SvStatusService';

class UpdateSvStatusComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                inService: ''
        }
        this.updateSvStatus = this.updateSvStatus.bind(this);

        this.changeinServiceHandler = this.changeinServiceHandler.bind(this);
    }

    componentDidMount(){
        SvStatusService.getSvStatusById(this.state.id).then( (res) =>{
            let svStatus = res.data;
            this.setState({
                inService: svStatus.inService
            });
        });
    }

    updateSvStatus = (e) => {
        e.preventDefault();
        let svStatus = {
            svStatusId: this.state.id,
            inService: this.state.inService
        };
        console.log('svStatus => ' + JSON.stringify(svStatus));
        console.log('id => ' + JSON.stringify(this.state.id));
        SvStatusService.updateSvStatus(svStatus).then( res => {
            this.props.history.push('/svStatuss');
        });
    }

    changeinServiceHandler= (event) => {
        this.setState({inService: event.target.value});
    }

    cancel(){
        this.props.history.push('/svStatuss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SvStatus</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> inService: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSvStatus}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateSvStatusComponent
