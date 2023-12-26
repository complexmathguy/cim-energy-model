import React, { Component } from 'react'
import SvStatusService from '../services/SvStatusService';

class CreateSvStatusComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                inService: ''
        }
        this.changeinServiceHandler = this.changeinServiceHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SvStatusService.getSvStatusById(this.state.id).then( (res) =>{
                let svStatus = res.data;
                this.setState({
                    inService: svStatus.inService
                });
            });
        }        
    }
    saveOrUpdateSvStatus = (e) => {
        e.preventDefault();
        let svStatus = {
                svStatusId: this.state.id,
                inService: this.state.inService
            };
        console.log('svStatus => ' + JSON.stringify(svStatus));

        // step 5
        if(this.state.id === '_add'){
            svStatus.svStatusId=''
            SvStatusService.createSvStatus(svStatus).then(res =>{
                this.props.history.push('/svStatuss');
            });
        }else{
            SvStatusService.updateSvStatus(svStatus).then( res => {
                this.props.history.push('/svStatuss');
            });
        }
    }
    
    changeinServiceHandler= (event) => {
        this.setState({inService: event.target.value});
    }

    cancel(){
        this.props.history.push('/svStatuss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SvStatus</h3>
        }else{
            return <h3 className="text-center">Update SvStatus</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> inService: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSvStatus}>Save</button>
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

export default CreateSvStatusComponent
