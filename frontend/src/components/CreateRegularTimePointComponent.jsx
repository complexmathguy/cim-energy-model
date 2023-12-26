import React, { Component } from 'react'
import RegularTimePointService from '../services/RegularTimePointService';

class CreateRegularTimePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                sequenceNumber: '',
                value1: '',
                value2: ''
        }
        this.changesequenceNumberHandler = this.changesequenceNumberHandler.bind(this);
        this.changevalue1Handler = this.changevalue1Handler.bind(this);
        this.changevalue2Handler = this.changevalue2Handler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            RegularTimePointService.getRegularTimePointById(this.state.id).then( (res) =>{
                let regularTimePoint = res.data;
                this.setState({
                    sequenceNumber: regularTimePoint.sequenceNumber,
                    value1: regularTimePoint.value1,
                    value2: regularTimePoint.value2
                });
            });
        }        
    }
    saveOrUpdateRegularTimePoint = (e) => {
        e.preventDefault();
        let regularTimePoint = {
                regularTimePointId: this.state.id,
                sequenceNumber: this.state.sequenceNumber,
                value1: this.state.value1,
                value2: this.state.value2
            };
        console.log('regularTimePoint => ' + JSON.stringify(regularTimePoint));

        // step 5
        if(this.state.id === '_add'){
            regularTimePoint.regularTimePointId=''
            RegularTimePointService.createRegularTimePoint(regularTimePoint).then(res =>{
                this.props.history.push('/regularTimePoints');
            });
        }else{
            RegularTimePointService.updateRegularTimePoint(regularTimePoint).then( res => {
                this.props.history.push('/regularTimePoints');
            });
        }
    }
    
    changesequenceNumberHandler= (event) => {
        this.setState({sequenceNumber: event.target.value});
    }
    changevalue1Handler= (event) => {
        this.setState({value1: event.target.value});
    }
    changevalue2Handler= (event) => {
        this.setState({value2: event.target.value});
    }

    cancel(){
        this.props.history.push('/regularTimePoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RegularTimePoint</h3>
        }else{
            return <h3 className="text-center">Update RegularTimePoint</h3>
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
                                            <label> sequenceNumber: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value2: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRegularTimePoint}>Save</button>
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

export default CreateRegularTimePointComponent
