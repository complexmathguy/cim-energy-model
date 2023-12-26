import React, { Component } from 'react'
import DateTimeService from '../services/DateTimeService';

class CreateDateTimeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DateTimeService.getDateTimeById(this.state.id).then( (res) =>{
                let dateTime = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDateTime = (e) => {
        e.preventDefault();
        let dateTime = {
                dateTimeId: this.state.id,
            };
        console.log('dateTime => ' + JSON.stringify(dateTime));

        // step 5
        if(this.state.id === '_add'){
            dateTime.dateTimeId=''
            DateTimeService.createDateTime(dateTime).then(res =>{
                this.props.history.push('/dateTimes');
            });
        }else{
            DateTimeService.updateDateTime(dateTime).then( res => {
                this.props.history.push('/dateTimes');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dateTimes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DateTime</h3>
        }else{
            return <h3 className="text-center">Update DateTime</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDateTime}>Save</button>
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

export default CreateDateTimeComponent
