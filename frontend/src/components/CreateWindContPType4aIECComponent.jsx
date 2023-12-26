import React, { Component } from 'react'
import WindContPType4aIECService from '../services/WindContPType4aIECService';

class CreateWindContPType4aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                dpmax: '',
                tpord: '',
                tufilt: ''
        }
        this.changedpmaxHandler = this.changedpmaxHandler.bind(this);
        this.changetpordHandler = this.changetpordHandler.bind(this);
        this.changetufiltHandler = this.changetufiltHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindContPType4aIECService.getWindContPType4aIECById(this.state.id).then( (res) =>{
                let windContPType4aIEC = res.data;
                this.setState({
                    dpmax: windContPType4aIEC.dpmax,
                    tpord: windContPType4aIEC.tpord,
                    tufilt: windContPType4aIEC.tufilt
                });
            });
        }        
    }
    saveOrUpdateWindContPType4aIEC = (e) => {
        e.preventDefault();
        let windContPType4aIEC = {
                windContPType4aIECId: this.state.id,
                dpmax: this.state.dpmax,
                tpord: this.state.tpord,
                tufilt: this.state.tufilt
            };
        console.log('windContPType4aIEC => ' + JSON.stringify(windContPType4aIEC));

        // step 5
        if(this.state.id === '_add'){
            windContPType4aIEC.windContPType4aIECId=''
            WindContPType4aIECService.createWindContPType4aIEC(windContPType4aIEC).then(res =>{
                this.props.history.push('/windContPType4aIECs');
            });
        }else{
            WindContPType4aIECService.updateWindContPType4aIEC(windContPType4aIEC).then( res => {
                this.props.history.push('/windContPType4aIECs');
            });
        }
    }
    
    changedpmaxHandler= (event) => {
        this.setState({dpmax: event.target.value});
    }
    changetpordHandler= (event) => {
        this.setState({tpord: event.target.value});
    }
    changetufiltHandler= (event) => {
        this.setState({tufilt: event.target.value});
    }

    cancel(){
        this.props.history.push('/windContPType4aIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContPType4aIEC</h3>
        }else{
            return <h3 className="text-center">Update WindContPType4aIEC</h3>
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
                                            <label> dpmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpord: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tufilt: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContPType4aIEC}>Save</button>
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

export default CreateWindContPType4aIECComponent
